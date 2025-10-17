@echo off
set WAR_NAME=Sprint.war
set SOURCE_DIR=
set DEST_DIR=D:\apache-tomcat-10.1.28\webapps

echo Copying %WAR_NAME% to %DEST_DIR% ...
copy "%WAR_NAME%" "%DEST_DIR%\%WAR_NAME%" /Y

if %ERRORLEVEL%==0 (
    echo Deploy successful.
) else (
    echo Deploy failed.
)
pause
