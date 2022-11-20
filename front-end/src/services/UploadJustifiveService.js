import axios from 'axios';

const URL = "http://localhost:8080/uploadjustification/upload-justification";

class UploadJustifiveService {

    postJustification(rut, date) {
        return axios.post(URL+"?rut="+rut+"&date="+date);

    }
}

export default new UploadJustifiveService()