function DollartoINR()
{
	const DollarInput=document.getElementById('Dollarinput').value;
	
	const INR=parseFloat(DollarInput)*82.89;
	
	document.getElementById('INROutput').value=INR.toFixed(2);
	}