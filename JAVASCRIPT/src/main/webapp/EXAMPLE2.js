var i;
var n=100;
for(i=1;i<=n;i++)
{
	 if(i%3===0)
	{
		document.write("FIZZ ");
	}
	else if(i%5===0)
	{
		document.write("BUZZ ");
	}
	else if(i%15===0)
	{
		document.write("FIZZBUZZ ");
	}
	else{
	document.write(i+" ");
	}
	}

	
