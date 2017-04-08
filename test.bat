@echo off
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main 
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main -h
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login XXX -pass XXX
echo.
echo EXPECTED 1, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass XXX
echo.
echo EXPECTED 2, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res a
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res a.b
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol XXX -res a.b
echo.
echo EXPECTED 3, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res XXX
echo.
echo EXPECTED 4, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol WRITE -res a
echo.
echo EXPECTED 4, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol WRITE -res a.bc
echo.
echo EXPECTED 4, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100
echo.
echo EXPECTED 0, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100
echo.
echo EXPECTED 5, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login jdoe -pass sup3rpaZZ -rol READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX

echo.
echo EXPECTED 5, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login X -pass X -rol READ -res X -ds 2015-01-01 -de 2015-12-31 -vol XXX
echo.
echo EXPECTED 1, GOT %ERRORLEVEL%
java -cp ./lib/commons-cli-1.3.1.jar;./out/production/PI/ com.Main  -login X -pass X -rol READ -res X
echo.
echo EXPECTED 1, GOT %ERRORLEVEL%
pause