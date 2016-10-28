package com.chapter12.genericProgramDesign;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * 
 * Generic Relection Test
 * 泛型反射测试
 *
 * @author   lixiong
 */
public class GenericReflectionTest {

    public static void main(String[] args) {
        try {
            Class<?> pair = Pair.class;
            Class<?> arrayAlg = ArrayAlg.class;
            printClass(pair);
            for(Method method : pair.getDeclaredMethods())
                printMethod(method);
            System.out.println("-----------------------------------------");
            printClass(arrayAlg);
            for(Method method : arrayAlg.getDeclaredMethods())
                printMethod(method);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printClass(Class<?> class1){
        System.out.print(class1);
        printTypes(class1.getTypeParameters(), "<", ", ", ">", true);
        Type type = class1.getGenericSuperclass();
        if(null != type){
            System.out.print(" extends ");
            printType(type, false);
        }
        printTypes(class1.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }
    
    private static void printMethod(Method method){
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        printTypes(method.getTypeParameters(), "<", ", ", ">", true);
        printType(method.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(method.getName());
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }
    
    private static void printType(Type type,boolean isDefinition){
        if(type instanceof Class<?>){
            Class<?> class1 = (Class<?>)type;
            System.out.print(class1.getName());
        }else if(type instanceof TypeVariable<?>) {
            TypeVariable<?> typeVariable = (TypeVariable<?>)type;
            System.out.print(typeVariable.getName());
            if(isDefinition)
                printTypes(typeVariable.getBounds(), " extends ", " & ", "", false);
        }else if (type instanceof WildcardType) {
            WildcardType wtType = (WildcardType)type;
            System.out.print("?");
            printTypes(wtType.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(wtType.getLowerBounds(), " super ", " & ", "", false);
        }else if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType)type;
            Type owner = pType.getOwnerType();
            if(null != owner){
                printType(owner, false);
                System.out.print(".");
            }
            printType(pType.getRawType(), false);
            printTypes(pType.getActualTypeArguments(), "<", ", ", ">", false);
        }else if (type instanceof GenericArrayType) {
            GenericArrayType gType = (GenericArrayType)type;
            System.out.print("");
            printType(gType.getGenericComponentType(), false);
            System.out.print("[]");
        }
    }
    
    private static void printTypes(Type[] types,String pre,String sep,String suf,boolean isDefinition){
        if(" extends ".equals(pre) && Arrays.equals(types, new Type[]{Object.class}) ){
            return;
        }
        if(types.length > 0)
            System.out.print(pre);
        for(int i = 0; i < types.length; i++){
            if(i > 0)
                System.out.print(sep);
            printType(types[i], isDefinition);
        }
        if(types.length > 0)
            System.out.print(suf);
    }

}
