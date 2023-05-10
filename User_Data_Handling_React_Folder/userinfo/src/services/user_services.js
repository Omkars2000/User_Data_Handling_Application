import { myAxios } from "./helper";

export const getAll=(user)=>{
    return myAxios.post('/api/o1/all').then((Response)=>Response.json())
}