function toCamelCase(str)
{
    let camelCase = '';
    for(let i=0; i<str.length;i++)
    {
        if(str[i] == '-' || str[i] == '_')
        {
            i++;
            camelCase = camelCase + str[i].toUpperCase();
            continue;
        }
        camelCase = camelCase + str[i];
    }
    return camelCase;
}

console.log(toCamelCase(''));
console.log(toCamelCase("the_stealth_warrior"));
console.log(toCamelCase("The-Stealth-Warrior"));
console.log(toCamelCase("A-B-C"));
