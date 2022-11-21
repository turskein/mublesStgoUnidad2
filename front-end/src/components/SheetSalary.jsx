import React, { Component } from 'react'
import GetSalariesService from '../services/GetSalariesService';

class SheetSalary extends Component {
    constructor(props) {
        super(props)

        this.state = {
            salarios: [
                <tr>
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
        GetSalariesService.getSalaries(month, year);
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
                    <button type="button" className="btn btn-primary" onClick={this.calcularSueldos}>Primary</button>
                </div>
                <table className="table table-striped">
                    <caption></caption>
                    <thead>
                        <tr>
                            <th scope="col">Rut</th>
                            <th scope="col">Sueldo</th>
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

export default SheetSalary