#!/usr/bin/env bash
current_path=$(dirname "$0")
path=$(cd ${current_path}; pwd)
##目标分支
branch=${1}
echo "当前路径为： ${path}"


function branchStatus() {
    for i in `ls ${path}`
    do
        if (( ${i:0:6} == "anytxn" ))
        then
            current_path=${path}/${i}
            echo ${current_path}
            cd ${current_path}

            git status
        fi
    done;
}

function checkBranch() {
    for i in `ls ${path}`
    do
        if (( ${i:0:6} == "anytxn" ))
        then
            current_path=${path}/${i}
            echo ${current_path}
            cd ${current_path}
            git stash save .
            git checkout ${branch}
            git pull
            git stash pop
        fi
    done;
}



if [[ ${branch} == "status" ]]; then
    echo "查看文件状态";
    branchStatus
else
    echo "切换分支拉取代码";
    checkBranch
fi










