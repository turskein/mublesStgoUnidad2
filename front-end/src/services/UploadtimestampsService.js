import axios from 'axios';

const TIMESTAMPSURL = "http://localhost:8080/uploadtimestamps/upload-timestamps";

class UploadtimestampsService {
    
    postTimestamps(file){
        const formData = new FormData();
        formData.append("file",file);
        axios.post(TIMESTAMPSURL, formData)
        .then(response => {return response;})
        .catch(error => {return error;});
    }
}

export default new UploadtimestampsService()