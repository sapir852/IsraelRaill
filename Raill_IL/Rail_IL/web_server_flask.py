#!/usr/bin/python
import subprocess

from flask import Flask, request

app = Flask("my_app1")

@app.route("/rail")
def rail_schedule():
    if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = "html"
    return subprocess.check_output(["java", "-classpath", "bin", "Main",
                                    outformat, request.args.get('source'), request.args.get('destination'), request.args.get('hour'), request.args.get('minutes')])


app.run(port=8005, host="0.0.0.0")
