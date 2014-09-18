/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ 
/*     */ public class CheckLicenseFile
/*     */ {
/*     */   private static final String publicKey = "308201b83082012d";
/*     */   private static SecretKeySpec key;
/*     */   private static Cipher cipher;
/*  29 */   private static byte[] linebreak = new byte[0];
/*     */   private static Base64 coder;
/*     */   
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/*  36 */       key = new SecretKeySpec("308201b83082012d".getBytes(), "AES");
/*  37 */       cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//					  cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*  38 */       coder = new Base64(32, linebreak, true);
/*     */     }
/*     */     catch (Throwable t)
/*     */     {
/*  41 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean checkLicenseLocations(String[] paths)//用户读取license文件
/*     */     throws Exception
/*     */   {
/*  48 */     String path = "";
/*  49 */     boolean found = false;
/*  50 */     for (int i = 0; i < paths.length; i++)
/*     */     {
/*  52 */       path = paths[i] + "viPlugin2.lic"; //license的文件名应该是 viPlugin2.lic
/*  53 */       if (new File(path).exists())
/*     */       {
/*  55 */         found = true;
/*  56 */         break;
/*     */       }
/*  59 */       path = paths[i] + "viplugin2.lic";
/*  60 */       if (new File(path).exists())
/*     */       {
/*  62 */         found = true;
/*  63 */         break;
/*     */       }
/*     */     }
/*  66 */     if (!found) {
/*  68 */       throw new Exception("License should be in one of the following locations:\n" + paths[0] + "\n" + paths[1]);
/*     */     }
/*  70 */     return checkLicenseFile(path);
/*     */   }
/*     */   
/*     */   private static boolean checkLicenseFile(String fileName) //检查密钥
/*     */     throws Exception
/*     */   {
/*  75 */     char[] buffer = new char[(int)new File(fileName).length()];
/*     */     try
/*     */     {
/*  79 */       FileReader fileReader = new FileReader(fileName);
/*  80 */       fileReader.read(buffer);
/*  81 */       fileReader.close();
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/*  84 */       throw new Exception("License file not found: " + fileName);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  87 */       throw new Exception("Can't read license file: " + fileName);
/*     */     }
/*     */     FileReader fileReader;
/*  90 */     String license = new String(buffer);
/*  91 */     if (!decrypt(license)) {
/*  93 */       throw new Exception("Invalid license found: " + fileName);
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public static synchronized String encrypt(String name, String email)//依照用户名和密码生成密钥
/*     */     throws Exception
/*     */   {
/* 100 */     String plainText = name + "viPlugin 2.0" + email;
/* 101 */     cipher.init(1, key);
/* 102 */     byte[] cipherText = cipher.doFinal(plainText.getBytes());
/* 103 */     return new String(coder.encode(cipherText));
/*     */   }
/*     */   
/*     */   public static synchronized boolean decrypt(String codedText)
/*     */     throws Exception
/*     */   {
/* 108 */     byte[] encypted = coder.decode(codedText.getBytes());
/* 109 */     cipher.init(2, key);
/* 110 */     byte[] decrypted = cipher.doFinal(encypted);
/* 111 */     String decoded = new String(decrypted);
/* 112 */     return decoded.contains("viPlugin 2.0");
/*     */   }
/*     */ }


/* Location:           E:\360data\重要数据\桌面\viPlugin_2.13.1\plugins\com.mbartl.viplugin.eclipse.layer_2.13.1\lib\licensechecker\
 * Qualified Name:     com.mbartl.viimplementation.license.CheckLicenseFile
 * JD-Core Version:    0.7.0.1
 */