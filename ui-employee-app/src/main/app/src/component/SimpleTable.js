import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';



class SimpleTable extends Component {

  constructor(props) {
    super(props);
    this.getProjectDetails = this.getProjectDetails.bind(this);


    this.state = {
     // projectDetails : [],
      token: null,
      name: null,
      projectDetailsChanged : this.props.projectDetailsChanged
    }

    //this.getProjectDetails()
  }


 getProjectDetails(){
    console.log(" -- getProjectDetails - ")
    //return [{ name :"Mediswitch", startDate : "10/10/2020", endDate : "10/10/2022"}]
     fetch("http://localhost:9191/projectdetails", {
                         headers: new Headers({
                           'Authorization': 'Bearer ' + this.props.token
                         }),
                       })
                         .then(res => res.json())
                         .then(
                           (result) => {
                             console.log(result)
                             console.log(" returning ")
                             //this.setState({projectDetails: result})
                             return result;
                           },
                           // Note: it's important to handle errors here
                           // instead of a catch() block so that we don't swallow
                           // exceptions from actual bugs in components.
                           (error) => {
                             this.setState({
                               isLoaded: true,
                               error
                             });
                           }
                         )
   }


  componentDidMount() {

  }
  
  render(){
  const projectDetailsLocal = this.getProjectDetails()
    return (
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Dessert (100g serving)</TableCell>
              <TableCell align="right">Calories</TableCell>
              <TableCell align="right">Fat&nbsp;(g)</TableCell>
              <TableCell align="right">Carbs&nbsp;(g)</TableCell>
              <TableCell align="right">Protein&nbsp;(g)</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {projectDetailsLocal.map((row) => (
              <TableRow key={row.name}>
                <TableCell component="th" scope="row">
                  {row.name}
                </TableCell>
                <TableCell align="right">{row.name}</TableCell>
                <TableCell align="right">{row.startDate}</TableCell>
                <TableCell align="right">{row.endDate}</TableCell>
              
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    );
  }
}


export default SimpleTable