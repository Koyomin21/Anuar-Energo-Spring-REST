var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;

}

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            console.log("Got message from topic/messages")
            console.log(messageOutput)
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var text = document.getElementById('text').value;
    stompClient.send("/app/userChat", {},
        JSON.stringify({'message':text}));
}

function showMessageOutput(messageOutput) {
    var body = document.getElementsByClassName("main-body");
    var row = document.getElementsByClassName("response-row");

    var newRow = row[0].cloneNode(false);
    var icon = document.getElementsByClassName("bi bi-person-circle")[0].cloneNode(true);
    var timeSpan = document.getElementsByClassName("time")[0].cloneNode(true);
    var textPar = document.getElementsByClassName("pText")[0].cloneNode(true);

    textPar.textContent = messageOutput.message;
    timeSpan.textContent = messageOutput.dateTime;

    newRow.appendChild(icon);
    newRow.appendChild(textPar);
    newRow.appendChild(timeSpan);

    console.log("Message Output Function")
    console.log(messageOutput)

    body[0].appendChild(newRow);
}