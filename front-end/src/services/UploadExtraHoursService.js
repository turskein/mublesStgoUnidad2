import axios from 'axios';
import GeneralRoute from './GeneralRoute';

const URL = GeneralRoute.get()+"/uploadextrahours";

class UploadExtraHoursService {
    
    postExtraHoours(rutInput,dateInput,amountInput){
        const token = localStorage.getItem("token");
        return axios.post(URL+"?rut="+rutInput+"&date="+dateInput+"&amount="+amountInput);

    }
}

export default new UploadExtraHoursService()