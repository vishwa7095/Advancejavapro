 function convertToReverse()
{
	const InputString=document.getElementById('string1Input').value;
	const ReversedString=InputString.split('').reverse().join('');
	document.getElementById('stringOutput').value=ReversedString;
}