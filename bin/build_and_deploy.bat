et APP=TicTacToe
set LOCATION=C:\temp

REM Always deploy new version, clean before
call bin\clean.bat
call bin\package.bat

if exist %LOCATION%\\%APP% rmdir /S /Q %LOCATION%\\%APP%

if not exist "%LOCATION%" mkdir %LOCATION%

xcopy /E build\install %LOCATION%
echo ************************************************************************
echo ** Travis report: https://travis-ci.org/iFellTower/TicTacToe          **
echo ************************************************************************
echo ** Code Coverage report: https://codecov.io/gh/iFellTower/TicTacToe/  **
echo ************************************************************************

%LOCATION%\\%APP%\\bin\\%APP%
