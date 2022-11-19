import React, { Component } from 'react'
import UploadtimestampsService from '../services/UploadtimestampsService';
import myStyles from '../styles/myStyles.css';

class UploadTimestampsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            file: null,
            myStyles,
            tableBody: null
        }
        this.inputNewFile = this.inputNewFile.bind(this);
    }
    componentDidMount(){
        this.setState({
            tableBody: document.getElementById('tableBody')
        });
    }
    inputNewFile() {
        var reader = new FileReader();
        reader.onload = () => {
            let table = this.state.tableBody;
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
        reader.readAsText(document.getElementById('inputFile').files[0]);
    }

    closeAlertSuccess() {
        document.getElementById("button-alert-success").setAttribute("hidden", true);
    }

    sendData() {
        UploadtimestampsService.postTimestamps(this.state.file)
            .then(() => {
                this.state.alert.removeAttribute("hidden");
            })
            .catch(e => {
                console.log(e);
            });
    }


    render() {
        return (
            <div>
                <div id="button-alert-success" hidden className="my-button">
                    <div className="alert alert-success alert-mine" role="alert" id="alert-success">
                        Las marcas de tiempo se han subido correctamente :D
                        <button className='closeButton alert alert-success' onClick={this.closeAlertSuccess}>
                            .
                        </button>
                    </div>
                </div>

                <div className="input-group mb-3">
                    <input type="file" className="form-control" id="inputFile" onChange={this.inputNewFile} />
                </div>
                <button type="button" className="my-1 btn btn-lg btn-dark" onClick={this.sendData}>Cargar Archivo</button>
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