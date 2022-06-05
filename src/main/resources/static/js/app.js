window.onload = () => {
    connect();
}

function connect() {
    var socket = new SockJS('/summermarket/cart-messaging');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected: " + frame);
        stompClient.subscribe('/user/queue/summ', function (response) {
            var data = JSON.parse(response.body);
            console.log(data);
            $('#resultInput').val(data);
        });
    });
}

function sendMessage() {
    stompClient.send("/app/message", {}, JSON.stringify(100));

}

