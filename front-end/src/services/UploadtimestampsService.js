import axios from 'axios';

const TIMESTAMPSURL = "http://localhost:8080/uploadtimestamps/upload-timestamps";

class UploadtimestampsService {
    
    postTimestamps(file){
        const formData = new FormData();
        formData.append("file",file);
        return axios.post(TIMESTAMPSURL, formData)

    }
}

export default new UploadtimestampsService()