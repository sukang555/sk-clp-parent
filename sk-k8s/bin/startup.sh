
PROJECT_HOME=/app

#JVM内存，不同的环境和模式设置不同

if [[ -z "$JVM_MEM_OPTS" ]]; then
    JAVA_MEM_OPTS="-Xms512m -Xmx1g -Xss256k -XX:MetaspaceSize=256m"
else
    JAVA_MEM_OPTS="${JVM_MEM_OPTS}"
fi



#启动日志是否输出
STARTUP_LOG="true"
PROFILE="${ENV_PROFILE}"


LOG_DIR=${PROJECT_HOME}/logs




if [[ ${CLASSPATH} ]]; then
    CLASSPATH="${CLASSPATH}:${PROJECT_HOME}/config:${PROJECT_HOME}/lib/*"
else
    CLASSPATH="${PROJECT_HOME}/config:${PROJECT_HOME}/lib/*"
fi


#GC日志参数
#-XX:+PrintGC 输出GC日志
#-XX:+PrintGCDetails 输出GC的详细日志
#-XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
#-XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
#-XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
#-Xloggc:../logs/gc.log 日志文件的输出路径
# -XX:+DisableExplicitGC 禁止显示的调用gc发方法
GC_OPTS="-XX:+DisableExplicitGC"
GC_OPTS="${GC_OPTS} -XX:+PrintGCDetails"
GC_OPTS="${GC_OPTS} -XX:+PrintGCDateStamps"
GC_OPTS="${GC_OPTS} -XX:GCLogFileSize=10M"
GC_OPTS="${GC_OPTS} -XX:NumberOfGCLogFiles=10"
GC_OPTS="${GC_OPTS} -XX:+UseGCLogFileRotation"
GC_OPTS="${GC_OPTS} -XX:ErrorFile=${LOG_DIR}/hs_err_pid.log"
GC_OPTS="${GC_OPTS} -Xloggc:${LOG_DIR}/gc.log"


#内存溢出记录dump文件
#HEAP_DUMP="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${LOG_DIR}/heap_dump_`date '+%Y-%m-%d—%H%M%S'`.hprof"
HEAP_DUMP="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${LOG_DIR}/"

JAVA_OPT="-Duser.timezone=GMT+8"

if [[ -n "${PROFILE}" ]]; then
  JAVA_OPT="${JAVA_OPT} -Dspring.profiles.active=${PROFILE}"
fi

#JAVA_OPT="${JAVA_OPT} -XX:+UnlockDiagnosticVMOptions -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
JAVA_OPT="${JAVA_OPT} -XX:+PrintCommandLineFlags"
JAVA_OPT="${JAVA_OPT} -XX:+UseG1GC"
JAVA_OPT="${JAVA_OPT} -XX:MaxGCPauseMillis=100"
JAVA_OPT="${JAVA_OPT} -XX:+UseFastAccessorMethods"
JAVA_OPT="${JAVA_OPT} -XX:+ParallelRefProcEnabled"


JAVA_OPT="${JAVA_MEM_OPTS} ${JAVA_OPT} ${GC_OPTS} ${HEAP_DUMP}"

# print out env properties
echo "工程目录: ${PROJECT_HOME}"
echo "配置文件变量：PROFILE=${PROFILE}"
echo "日志目录：LOG_DIR=${LOG_DIR}"
echo "JAVA_HOME=${JAVA_HOME}/bin/java"
echo "JAVA_OPT=${JAVA_OPT}"



#创建日志文件和目录
logDir(){
    if [[ ! -d "${LOG_DIR}" ]]; then
        mkdir "${LOG_DIR}"
    fi
}

#执行主命令
executeMain(){
    if [[ "${STARTUP_LOG}" = "true" ]]; then
        echo "执行命令:  ${JAVA_OPT} -cp ${CLASSPATH} ${APPLICATION_MAIN}"
        ${JAVA_HOME}/bin/java ${JAVA_OPT} -cp ${CLASSPATH} ${APPLICATION_MAIN}
    else
        echo "执行命令:  ${JAVA_OPT} -cp ${CLASSPATH} ${APPLICATION_MAIN}"
        ${JAVA_HOME}/bin/java ${JAVA_OPT} -cp ${CLASSPATH} ${APPLICATION_MAIN}
    fi
}


startup(){
    logDir
    echo "Start Running  ${APPLICATION_MAIN}"
    executeMain
    sleep 1
}

#服务启动
startup


