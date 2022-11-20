import axios from 'axios';

const URL = "http://localhost:8080/uploadextrahours";

class UploadExtraHoursService {
    
    postExtraHoours(rutInput,dateInput,amountInput){
        return axios.post(URL+"?rut="+rutInput+"&date="+dateInput+"&amount="+amountInput);

    }
}

export default new UploadExtraHoursService()