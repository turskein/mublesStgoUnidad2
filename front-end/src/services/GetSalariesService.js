import axios from 'axios';
import GeneralRoute from './GeneralRoute';

const URL = GeneralRoute.get() + "/salaries/reports";

class GetSalariesService {

    getSalaries(month, anio) {
        var token = localStorage.getItem('token');
        const headers = {
            header: {
                Authorization: `Bearer ${token}`,
            }
        }
        return axios.get(URL + "?month=" + month + "&year=" + anio,headers)
    }
}

export default new GetSalariesService()