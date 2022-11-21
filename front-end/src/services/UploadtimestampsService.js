import axios from 'axios';
import GeneralRoute from './GeneralRoute';

const TIMESTAMPSURL = GeneralRoute.get()+"/uploadtimestamps/upload-timestamps";

class UploadtimestampsService {
    
    postTimestamps(file){
        const formData = new FormData();
        formData.append("file",file);
        const token = localStorage.getItem("token");
        return axios.post(TIMESTAMPSURL, formData,{header: {Authorization: `Bearer ${token}`}})

    }
}

export default new UploadtimestampsService()