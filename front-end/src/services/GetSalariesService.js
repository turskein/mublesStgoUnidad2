import axios from 'axios';

const URL = "http://localhost:8080/salaries/reports";

class GetSalariesService {
    
    getSalaries(month,anio){
        return axios.get(URL+"?month="+month+"&year="+anio)
    }
}

export default new GetSalariesService()