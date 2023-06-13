function fCheck(){
	with(frm){
		let re1 = /^\s*$/
		if(re1.test(name.value)){
			alert("Please, enter your name")
			name.value=""
	        name.focus()
	        return false
	    }
	    if(re1.test(address.value)){
	    	alert("Please, enter your address")
		    address.value=""
	        address.focus()
	        return false
	    }
	    if(re1.test(email.value)){
	    	alert("Please, enter your email")
		    email.value=""
	        email.focus()
	        return false
	    }
	    if(re1.test(telephone.value)){
	    	alert("Please, enter your telephone")
		    telephone.value=""
	        telephone.focus()
	        return false
	    }
	    if(!magazine[0].checked && !magazine[1].checked && !magazine[2].checked && !magazine[3].checked ){
	    	alert("Please, choose atleast one magazines!")
	        //magazine.focus();
	        return false
	    }

	    let re2 = /^\(\d{1,2}\)\-\d{1,3}\-\d{6,9}$/
	    if(!re2.test(telephone.value)){
	    	alert("Telephone is not correct")
	    	telephone.select();
	    	//telephone.focus()
	    	return false
	    }

	    let re3 = /^.+@[a-z]+(\.[a-z]{2,3}){1,2}$/
	    if(!re3.test(email.value)){
	    	alert("Email is not correct")
	    	email.select()
	    	return false
	    }
	    let str = "Thanks, " + sex.value + " " +name.value + " is a " + job.value+ "."
	    str+="\n You are booking : "
	    let count=0, i=0;
	    for(i in magazine){
	    	if(magazine[i].checked){
	    		count++;
	    	}
	    }
	    if(count==1){
	    	for(i in magazine){
	    	    if(magazine[i].checked){
	    	    	str+=magazine[i].value + "."
	    	    	break
	    	    }
	    	}
	    }else{
	    	for(i in magazine){
	    		if(magazine[i].checked){
	    			str+=magazine[i].value;
	    			break;
	    		}
	    	}
	    	for(let j=parseInt(i)+1; j<magazine.length;j++){
	    		if(magazine[j].checked){
	    			str+=", "+magazine[j].value
	    		}
	    	}
	    	str+="."
	    }
	    alert(str)
	    return false
	}
}