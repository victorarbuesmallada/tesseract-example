#!/bin/bash

function validate() {
    if [ -z "$FILE_PATH" ]; then
        echo File path is mandatory
        exit 0
    fi
    if [ -z "$FILE_OUTPUT" ]; then
        FILE_OUTPUT=$FILE_PATH
    fi
}

while [ $# -gt 0 ]
do
    case "$1" in
        -f | --file-path)
            FILE_PATH=$2
            shift
        ;;
        -o | --file-output)
            FILE_OUTPUT=$2
            shift
        ;;
        -d | --dpi)
            DPI=$2
            shift
        ;;
        -l | --language)
            LANGUAGE=$2
            shift
        ;;
    esac
    shift
done

validate

sbt "run -f=$FILE_PATH -o=$FILE_OUTPUT -l=$LANGUAGE"
