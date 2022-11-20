import React, { Component } from 'react'
import GetSalariesService from '../services/GetSalariesService';

class ReportSalaries extends Component {
    constructor(props) {
        super(props)

        this.state = {
            salarios: [
                <tr>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
            ]
        }
        this.calcularSueldos = this.calcularSueldos.bind(this);
    }

    calcularSueldos() {
        var month = document.getElementById("input-month").value;
        var year = document.getElementById("input-year").value;
        GetSalariesService.getSalaries(month, year)
            .then(response => {
                var data = response.data;

                var newSalarios = [];
                data.forEach(element => {
                    newSalarios.push(
                        <tr>
                            <td>{element.rut}</td>
                            <td>{element.name}</td>
                            <td>{element.serviceYears}</td>
                            <td>{element.fixedSalary}</td>
                            <td>{element.bonificationsSalary}</td>
                            <td>{element.discountsSalary}</td>
                            <td>{element.rawSalary}</td>
                            <td>{element.previsionalSalary}</td>
                            <td>{element.healthSalary}</td>
                            <td>{element.realSsalary}</td>
                        </tr>
                    );
                });
                console.log(data);
                this.setState({
                    salarios: newSalarios
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
        return (
            <div className="container mt-3">
                <h2>Plantilla de sueldos</h2>
                <div className="input-group mb-3">
                    <span className="input-group-text">Mes</span>
                    <input type="number" className="form-control" id="input-month" defaultValue={9} />
                    <span className="input-group-text">Año</span>
                    <input type="number" className="form-control" id="input-year" defaultValue={2022} />
                    <button type="button" class="btn btn-primary" onClick={this.calcularSueldos}>Primary</button>
                </div>
                <table className="table table-striped">
                    <caption></caption>
                    <thead>
                        <tr>
                            <th scope="col">Rut</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Años de servicio</th>
                            <th scope="col">Sueldo Fijo Mensual</th>
                            <th scope="col">Bonificaciones</th>
                            <th scope="col">Descuentos</th>
                            <th scope="col">Sueldo Bruto</th>
                            <th scope="col">Dscto Previsional</th>
                            <th scope="col">Dscto Salud</th>
                            <th scope="col">Sueldo Final</th>
                        </tr>
                    </thead>
                    <tbody id="tablebody">
                        {
                            this.state.salarios
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default ReportSalaries