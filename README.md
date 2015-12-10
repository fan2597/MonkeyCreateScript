# MonkeyCreateScript
随机生成Monkey脚本工具,使用说明

一.通过设置一个bat批处理来设置脚本

::设置循环执行的命令
set LAUNCH_APP_CMD=""
:: 这种执行自定义命令的次数间隔，默认30次事件执行一次命令
set INTERVAL=50

:: 设置各个事件的次数，是次数非百分比
set TOUCH=100
set MOTION=100
set PINCH_ZOOM=50
set TRACKBALL=10
set ROTATION=50
set NAV=50
set MAJOR_NAV=500
set SYSKEYS=500
set FLIP=10
set ANY_ENENT=1
set LONG_PRESS=1
set HORIZONTAL_SLIP=1

:: 设置屏幕分辨率
set WIDTH=720
set HEIGHT=1080

:: 设置运行的应用参数为 notification，incallui-电话号码
set APP=noapp
:: 设置限制坐标，不被TOUCH事件点击到 格式单个区域限制0,0,0,0 多个区域限制0,0,0,0|0,0,0,0 
set LIMIT_COORD=0,0,0,0
::设置重点点击坐标区域，与重点坐标点击次数
set KEY_COORD=164,1582,1080,1920
set PCT_KEY_COORD=0

::执行生成脚本命令
java -jar MonkeyScript.jar --launch-app %LAUNCH_APP_CMD% --width %WIDTH% --height %HEIGHT% --pct-touch %TOUCH% --pct-motion %MOTION% --pct-pinchzoom %PINCH_ZOOM% --pct-trackball %TRACKBALL% --pct-rotation %ROTATION% --pct-nav %NAV% --pct-majornav %MAJOR_NAV% --pct-syskeys %SYSKEYS% --pct-flip %FLIP% --pct-anyevent %ANY_ENENT% --pct-longpress %LONG_PRESS% --app %APP% --limit_coor %LIMIT_COORD% --pct-horizontal_slip %HORIZONTAL_SLIP% --key_coor %KEY_COORD% --pct-key-coord %PCT_KEY_COORD% --interval %INTERVAL%
pause

二.创建monkeycmd.txt文件
monkey -f /data/local/tmp/monkeyscript.txt --ignore-crashes --ignore-timeouts -v -v -v 300 1>/data/local/tmp/monkeyinfo.txt 2>/data/local/tmp/monkeyerror.txt

三.设置运行bat，批处理
adb -d push monkeyscript.txt /data/local/tmp/
adb -d shell < monkeycmd.txt
pause


