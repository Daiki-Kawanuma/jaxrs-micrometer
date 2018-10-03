if [ $# -ne 3 ]; then
    echo "shell parameters must be three."
    exit 1
fi

echo "install parameters - maven: $1, jdk: $2, maven command: $3"
echo "curent path - $(pwd)"

docker run -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:$1-$2 $3
