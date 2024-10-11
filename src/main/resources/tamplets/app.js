let ws, currentUser;

function connect() {
  ws = new WebSocket("ws://localhost:8080/hello");

  ws.onmessage = function (e) {
    console.log(e);
    printMessage(e.data);
  };

  ws.onclose = function () {
    alert("Disconnected from the server.");
    document.getElementById("connectButton").disabled = false;
    document.getElementById("connectButton").value = "Connect";
    document.getElementById("name").disabled = false;
  };

  document.getElementById("connectButton").disabled = true;
  document.getElementById("connectButton").value = "Connected";
  document.getElementById("name").disabled = true;
  currentUser = document.getElementById("name").value;
  console.log(currentUser);
}

function printMessage(data) {
  let messages = document.getElementById("messages");
  let messageData = JSON.parse(data);
  let newMessage = document.createElement("div");
  newMessage.className = "incoming-message";
  newMessage.innerHTML = messageData.name + " : " + messageData.message;
  messages.appendChild(newMessage);
  messages.scrollTop = messages.scrollHeight; // Scroll to the bottom
}

function sendToGroupChat() {
  if (ws == undefined) return;

  let messageText = document.getElementById("message").value.trim();
  if (!messageText) return; // Prevent sending empty messages

  document.getElementById("message").value = "";
  let name = currentUser; // Use the current user's name

  let messageObject = {
    name: name,
    message: messageText,
  };

  let newMessage = document.createElement("div");
  newMessage.innerHTML = messageText + " : " + currentUser;
  newMessage.className = "outgoing-message";
  document.getElementById("messages").appendChild(newMessage);

  ws.send(JSON.stringify(messageObject));
}
