@echo off
gradlew build
pause
xcopy .\build\libs\modid-1.0.jar %appdata%\.minecraft\mods\modid-1.0.jar /W
data
time
pause