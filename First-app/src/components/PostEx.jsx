import { useRef,useState } from "react";
import axios from "axios";
const PostEx=()=>{
    const [obj,setObj]=useState({});

    const email_box= useRef(null);
    const password_box=useRef(null);

    const func_one=()=>{
        const test_func=async ()=>{
            const res = await axios.post(`https://reqres.in/api/register`,{'email':email_box.current.value,
                                                                           'password':password_box.current.value });
            const {data}=res;
            setObj(data);
        }
        test_func();
    }
    return(
        <>
        <fieldset>
            <legend>Register</legend>
            <input type="email" ref={email_box} placeholder="enter your email"></input>
            <input type="password" ref={password_box} placeholder="Enter your password"></input>
            <br>
            </br>
            <button onClick={func_one}>Login</button>
            json.stringify(obj);
        </fieldset>
        </>
    )
}