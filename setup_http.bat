@echo off
cd http_server
echo Setting up the server...
python -m http.server 8080
