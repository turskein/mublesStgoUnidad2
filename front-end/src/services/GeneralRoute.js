const URL = "http://localhost:8080";

class GetSalariesService {
    get(){
        return URL;
    }
}

export default new GetSalariesService()