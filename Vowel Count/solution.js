//Solution by @Spion_Spion(Kacper2048)
function getCount(str)
{
    let count = 0;
    for(let i in str)
    {
        if(str[i] === 'a' || str[i] === 'e' || str[i] === 'i' || str[i] === 'o' || str[i] === 'u')
            count++;
    }
    return count;
}

console.log(getCount("abracadabra"));
