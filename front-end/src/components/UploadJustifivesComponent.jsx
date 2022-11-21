import React, { Component } from 'react'
import UploadJustifiveService from '../services/UploadJustifiveService';
import UploadExtraHoursService from '../services/UploadExtraHoursService';

class UploadJustifivesComponent extends Component {
    hideAlertSuccess() {
        document.getElementById('alert-success').setAttribute("hidden", true);
    }
    hideAlertWarning() {
        document.getElementById('alert-warning').setAttribute("hidden", true);
    }
    hideAlertProblem() {
        document.getElementById('alert-danger').setAttribute("hidden", true);
    }

    showByValueINput() {
        let valueSelected = document.getElementById('type-justifive').value;
        console.log(valueSelected);
        if (valueSelected === "1") {
            document.getElementById("div-justificativo-horas-extras").removeAttribute("hidden");
            document.getElementById('div-justificativo-falta').setAttribute("hidden", true);
        } else if (valueSelected === "2") {
            document.getElementById("div-justificativo-falta").removeAttribute("hidden");
            document.getElementById('div-justificativo-horas-extras').setAttribute("hidden", true);
        } else {
            document.getElementById('div-justificativo-horas-extras').setAttribute("hidden", true);
            document.getElementById('div-justificativo-falta').setAttribute("hidden", true);
        }
    }

    uploadJustifive() {
        var dateRetrasos = document.getElementById('date-retrasos').value;
        var rutRetrasos = document.getElementById('rut-retrasos').value;
        dateRetrasos = dateRetrasos.replace(/-/g, '/');
        if (dateRetrasos === "" || rutRetrasos === "") {
            document.getElementById('alert-warning').removeAttribute("hidden");
            return;
        }
        console.log(dateRetrasos);
        UploadJustifiveService.postJustification(rutRetrasos, dateRetrasos)
            .then(response => {
                document.getElementById('alert-success').removeAttribute("hidden");
                console.log(response);

            })
            .catch(e => {
                console.log(e);
                document.getElementById('alert-danger').removeAttribute("hidden");
            })
    }

    uploadExtraHours() {
        var dateRetrasos = document.getElementById('date-horas-extras').value;
        var rutRetrasos = document.getElementById('extra-hours').value;
        var amountJustifive = document.getElementById('amount-horas-extras').value;
        dateRetrasos = dateRetrasos.replace(/-/g, '/');
        if (dateRetrasos === "" || rutRetrasos === "" || amountJustifive === "") {
            document.getElementById('alert-warning').removeAttribute("hidden");
            return;
        }
        console.log(dateRetrasos);
        UploadExtraHoursService.postExtraHoours(rutRetrasos, dateRetrasos, amountJustifive)
            .then(response => {
                document.getElementById('alert-success').removeAttribute("hidden");
                console.log(response);
            })
            .catch(e => {
                console.log(e);
                document.getElementById('alert-danger').removeAttribute("hidden");
            })
    }

    render() {
        return (

            <div>
                {/* alert success */}
                <div className="mt-2 alert alert-success row justify-content-between" hidden role="alert" id="alert-success" >
                    <div className="mt-2 col">
                        <p>El justificativo se ingreso correctamente :D </p>
                    </div>
                    <div className="col-1 mt-1">
                        <button type="button" className="btn btn-success my-0" onClick={this.hideAlertSuccess}>Close</button>
                    </div>
                </div>
                {/* alert warning */}
                <div className="mt-2 alert alert-warning row justify-content-between" hidden role="alert" id="alert-warning">
                    <div className="mt-2 col">
                        <p>Le hace falta ingresar los datos</p>
                    </div>
                    <div className="col-1 mt-1">
                        <button type="button" className="btn btn-warning my-0" onClick={this.hideAlertWarning}>Close</button>
                    </div>
                </div>
                {/* alert error */}
                <div className="mt-2 alert alert-danger row justify-content-between" hidden role="alert" id="alert-danger">
                    <div className="mt-2 col">
                        <p>Hubo un problema con el justificativo, intentalo nuevamente</p>
                    </div>
                    <div className="col-1 mt-1">
                        <button type="button" className="btn btn-danger my-0" onClick={this.hideAlertProblem}>Close</button>
                    </div>
                </div>
                {/* Input de opcion */}
                <div className="mt-1 mb-0 px-5 py-3 col-4">
                    <label className="form-label ps-1"> Tipo de justiticativo</label>
                    <select className="form-select" aria-label="Default select example" id="type-justifive" onChange={this.showByValueINput}>
                        <option value="0" defaultValue>Seleccionar tipo de justificativo</option>
                        <option value="1">Horas extras</option>
                        <option value="2">Atrasos y Faltas</option>
                    </select>
                </div>
                {/* Justificativo de falta */}
                <div id="div-justificativo-falta" className="px-5" hidden>
                    <h3>Justificativo de atraso</h3>
                    <div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Rut</label>
                            <input placeholder="Ingrese el rut del empleado" type="text" className="form-control" id="rut-retrasos" aria-describedby="emailHelp" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputPassword1" className="form-label">Fecha</label>
                            <input type="date" className="form-control" id="date-retrasos" />
                            <div id="date-retrasos" className="form-text">Ingrese la fecha del día de atraso</div>
                        </div>
                        <button id="button-retrasos" className="btn btn-primary" onClick={this.uploadJustifive}>Crear</button>
                    </div>
                </div>
                {/* Justificativo de horas extras */}
                <div id="div-justificativo-horas-extras" className="px-5" hidden>
                    <h3>Justificativo de horas extras</h3>
                    <div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Rut</label>
                            <input placeholder="Ingrese el rut del empleado" type="text" className="form-control" id="extra-hours" aria-describedby="emailHelp" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputPassword1" className="form-label">Fecha</label>
                            <input type="date" name="date" className="form-control" id="date-horas-extras" />
                            <div id="date-horas-extras" className="form-text">Ingrese la fecha del día</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputPassword1" className="form-label">Cantidad de horas</label>
                            <input name="amount" field="justificationEntity.amount" type="number" className="form-control" id="amount-horas-extras" />
                        </div>
                        <button onClick={this.uploadExtraHours} className="btn btn-primary">Crear</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default UploadJustifivesComponent