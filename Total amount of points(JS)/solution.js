//Solution by @Spion_Spion(Kacper2048)
function points(games)
{
    let pointSum = 0;
    games.forEach(function(element)
    {
        let pointsA = parseInt(element.substring(0,element.indexOf(':')))
        let pointsB = parseInt(element.substring(element.indexOf(':')+1,games.length))

        if(pointsA > pointsB)
            pointSum+=3;
        else if(pointsA == pointsB)
            pointSum++;
    });
    return pointSum;
}

console.log(points(["1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"]));
console.log(points(["1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"]));
console.log(points(["0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"]));
console.log(points(["1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"]));
console.log(points(["1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"]));