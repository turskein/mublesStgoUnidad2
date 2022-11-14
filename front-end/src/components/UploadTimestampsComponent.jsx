import React, { Component } from 'react'
import UploadtimestampsService from '../services/UploadtimestampsService';

class UploadTimestampsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            file: null
        }
    }



    componentDidMount() {
        document.getElementById('inputFile').addEventListener('change', () => {
            this.setState({file: document.getElementById('inputFile').files[0]});
            var reader = new FileReader();
            reader.onload = () => {
                let table = document.getElementById('tableBody');
                table.innerHTML = '';
                let allText = reader.result;
                allText = allText.split("\n");

                for (let i = 0; i < allText.length; i++) {
                    let subSplit = allText[i].split(";");
                    const row = table.insertRow();
                    if (subSplit[0]) {
                        row.innerHTML = `
                        <th scope="row">${i + 1}</th>
                        <td>${subSplit[0]}</td>
                        <td>${subSplit[1]}</td>
                        <td>${subSplit[2]}</td>
                    `;
                    }
                }
            }
            reader.readAsText(this.state.file);
        })

        document.getElementById("sendDocument").addEventListener('click',()=>{
            console.log(UploadtimestampsService.postTimestamps(this.state.file));
        })
    }

    render() {
        return (
            <div>
                <div className="input-group mb-3">
                    <input type="file" className="form-control" id="inputFile" />
                </div>
                <button type="button" className="my-1 btn btn-lg btn-dark" id="sendDocument">Cargar Archivo</button>
                <div id="mitexto">
                    <table className="table">
                        <caption></caption>
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Hora</th>
                                <th scope="col">Rut</th>
                            </tr>
                        </thead>
                        <tbody id="tableBody">
                            <tr>
                                <th scope="row">0</th>
                                <td>Vacío</td>
                                <td>Vacío</td>
                                <td>Vacío</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        )
    }
}

export default UploadTimestampsComponent