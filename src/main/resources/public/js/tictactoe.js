function makeMove(tile){
    $.ajax({
        type: 'POST',
        url: '/makeMove',
        data: {
            'tile': tile
        }
    }).done(function(success) {
        var move = JSON.parse(success);
        if(move.player === 'X'){
            var d = document.getElementById(tile);
            d.className = "tile cross";
            d.innerHTML = move.player;
        } else {
            var d = document.getElementById(tile);
            d.className = "tile circle";
            d.innerHTML = move.player;
        }
        /// After we make the move we need to change the player
    }).fail(function() {
        console.log("Could not make move");
    });
}

function newGame(){
    $.ajax({
        type: 'POST',
        url: '/newGame'
    });
    /// clear table
    clearBoard();
}

function clearBoard(){
    for(var i = 1; i <= 9; i++){
        document.getElementById(i).innerHTML = "";
    }
}

function resetGame(){
    $.ajax({
        type: 'POST',
        url: '/clearGame'
    }).done(function() {
        clearBoard();
        getScores();
    }).fail(function() {
        console.log("could not initiate new game");
    });
}

function checkWinner(){
    $.ajax({
        type: 'GET',
        url: '/checkWinner'
    }).done(function(success) {
        var winner = JSON.parse(success);
        if(winner.status === true){
            alert("Congrats to player " + winner.player + ", for winnig the game");
            newGame();
        } else {
            checkDraw();
        }
    }).fail(function(){
        console.log("Check winner function failed");
    });
}

function getScores(){
    $.ajax({
        type: 'GET',
        url: '/getScores'
    }).done(function(scores) {
        var score = JSON.parse(scores);
        document.getElementById('playerX').innerHTML = score.playerX;
        document.getElementById('playerO').innerHTML = score.playerO;
    }).fail(function(){
        console.log("Could not get scores");
    });
}


function checkDraw(){
    $.ajax({
        type: 'GET',
        url: '/checkDraw'
    }).done(function(success){
        var draw = JSON.parse(success);
        if(draw.status === true){
            alert("There was a draw");
            newGame();
        }
    }).fail(function() {
        console.log("could not check for draw");
    });
};
