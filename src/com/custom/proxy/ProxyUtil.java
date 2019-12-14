package com.custom.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;

/**
 * 模拟jdk的动态代理
 */
public class ProxyUtil {

    public static Object newProxyInstance(Class<?>[] interfaces, InvocationHandler h){
        String proxyPackageName = "package com.waterplan.proxy;";

        String proxyImportStr ="import java.lang.reflect.Method; \nimport java.lang.reflect.InvocationHandler;" ;
        
        proxyPackageName+= "\n"+proxyImportStr;
        String proxyClassName = "public class Proxy$0  implements ";
        String proxyFiledStr = "private  InvocationHandler h;\n private Class[] source;";
        //构造方法
        String proxyConstructorStr = "public Proxy$0(InvocationHandler h, Class[] source) {"+"\n"+"    this.h = h; this.source = source; }";
        proxyConstructorStr+="\n"+proxyFiledStr;
        String methodContexts = "";

        int  count = 0;
        //获取接口中需要实现的方法
        for (Class<?> proxyInterface : interfaces) {
            proxyClassName += " "+proxyInterface.getName()+",";
            Method[] methods = proxyInterface.getMethods();
            for (Method method : methods) {
                if(Modifier.isPublic(method.getModifiers())){
                    String returnTypeStr = method.getReturnType().getName();
                    String methodNameStr = method.getName();
                    String methodStr = "public "+returnTypeStr + " "+methodNameStr+"(";
                    Parameter[] parameters = method.getParameters();
                    String argStr = "";
                    String paramtTypeClassStr ="";
                    for (Parameter parameter : parameters) {
                        String paramtTypeName = parameter.getType().getName();
                        String paramtName = parameter.getName();
                        argStr+=paramtName+",";
                        methodStr +=paramtTypeName+" "+paramtName+",";
                        paramtTypeClassStr+=paramtName+".getClass(),";

                    }
                    methodStr = methodStr.substring(0,methodStr.length()-1);
                    paramtTypeClassStr = paramtTypeClassStr.substring(0,paramtTypeClassStr.length()-1);
                    methodStr+=") {\n";
                    argStr= argStr.substring(0,argStr.length()-1);
                    methodStr +=" try {";
                    methodStr += " Method method = source["+count+"].getMethod(\""+method.getName()+"\","+paramtTypeClassStr+");\n";
                    String returnStr = "";
                    if(!returnTypeStr.equals("void")){
                        returnStr+= "return null;";
                        methodStr+=" return ("+returnTypeStr+")";
                    }
                    methodStr +="h.invoke( this, method, new Object[]{"+argStr+"});";

                    methodStr +="} catch (Throwable throwable) {\n" +
                            "            throwable.printStackTrace();\n" +
                            "        }";
                    methodContexts +=methodStr+returnStr;
                    methodContexts+="\n}\n";

                }
            }
            count++;
        }
        proxyClassName = proxyClassName.substring(0,proxyClassName.length()-1);

        proxyClassName+="\n"+"{";
        proxyClassName+="\n"+proxyConstructorStr;
        proxyClassName+="\n"+methodContexts;
        proxyPackageName +="\n"+proxyClassName+"}";

        String tmpFolder=System.getProperty("java.io.tmpdir");
        tmpFolder+="com\\waterplan\\proxy";
        File file = new File(tmpFolder);
        
        File classFile = new File(tmpFolder+"\\Proxy$0.java");
        FileWriter writer = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
             writer = new FileWriter(classFile);
            writer.write(proxyPackageName);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, Charset.defaultCharset());
            Iterable<? extends JavaFileObject> it = standardFileManager.getJavaFileObjects(classFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, it);
            task.call();
            standardFileManager.close();
            String urlStr = "file:"+System.getProperty("java.io.tmpdir");
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(urlStr)});
            try {
                Class<?> targetClass = urlClassLoader.loadClass("com.waterplan.proxy.Proxy$0");
                Class targetClss = h.getClass().getInterfaces()[0];
                Constructor<?> constructor = targetClass.getConstructor(targetClss,interfaces.getClass());
                try {
                    Object proxy = constructor.newInstance(h, interfaces);
                    return proxy;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
