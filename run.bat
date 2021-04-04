set projectLocation=D:\Opensourceworkspace\Udemy
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml 
