import axios from 'axios';
import GeneralRoute from './GeneralRoute';
const URL = GeneralRoute.get()+"/uploadjustification/upload-justification";

class UploadJustifiveService {

    postJustification(rut, date) {
        return axios.post(URL+"?rut="+rut+"&date="+date);

    }
}

export default new UploadJustifiveService()