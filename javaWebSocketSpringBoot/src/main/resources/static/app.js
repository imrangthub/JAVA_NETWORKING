var ws;
var ws1;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
}

function connect() {
	ws = new WebSocket('ws://localhost:8080/user');
	ws.onmessage = function(data) {
		helloWorld(data.data);
	}
	
	ws1 = new WebSocket('ws://localhost:8080/simpleChat');
	ws1.onmessage = function(data) {
		simpleMsgListShow(data.data);
	}
	
	
	setConnected(true);
}

function disconnect() {
	if (ws != null) {
		ws.close();
	}
	if (ws1 != null) {
		ws1.close();
	}
	setConnected(false);
	console.log("Websocket is in disconnected state");
}

function sendData() {
	var data = JSON.stringify({
		'user' : $("#user").val()
	})
	ws.send(data);
}

function simpleChatSend() {
	var data = JSON.stringify({
		'userMsg' : $("#simpleChat").val()
	})
	ws1.send(data);
}

function helloWorld(message) {
	$("#helloworldmessage").append("<tr><td> " + message + "</td></tr>");
}

function simpleMsgListShow(message) {
	$("#simpleMsgList").append("<tr><td> " + message + "</td></tr>");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendData();
	});
	
    $("#simpleChatSend").click(function() {
		simpleChatSend();
	});
	
});
