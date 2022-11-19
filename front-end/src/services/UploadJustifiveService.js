import axios from 'axios';

const URL = "http://localhost:8080/uploadjustification/upload-justification";

class UploadJustifiveService {

    postJustification(rutInput, dateInput) {
        return axios.post(URL, {
            rut: dateInput,
            date: dateInput
        }
        );

    }
}

export default new UploadJustifiveService()