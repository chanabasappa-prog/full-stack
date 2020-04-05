import React, { Component } from 'react';
import Cookies from 'js-cookie';
import './App.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import SimpleModal from './component/SimpleModal'
import SimpleTable from './component/SimpleTable'




class App extends Component {


  constructor(props) {
    super(props);
    this.logout = this.logout.bind(this);
    this.addProject = this.addProject.bind(this);


    this.state = {
      isLoaded: true,
      token: null,
      projectDetails: [],
      name: null,
      projectDetailsChanged : false

    }
  }

  logout() {
    console.log("herer")
    Cookies.remove('access_token_cookie');
    this.setState({ token: null });

  }
  rand() {
    return Math.round(Math.random() * 20) - 10;
  }

  addProject(){
    console.log("Add Project called")
    this.setState({projectDetailsChanged : true})
  }



  componentDidMount() {
    console.log("Compopnent mounted")

    fetch("user").then(res => res.json())
      .then(
        (result) => {
          console.log(result)
          this.setState({
            isLoaded: true,
            token: result.token,
            name: result.name
          });
          console.log("Done...")

        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          console.log("Error")
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
    console.log("Token : " + this.state.token)


  }



  render() {
    return <div className="App">







      <Container>
        <Row>
          <Col>{this.state.token ? (
            <p>Logged In Already</p>
          ) : (
              <p><a
                className="App-link"
                href="securedPage"
                target="_self"
                rel="noopener noreferrer"
              >
                Login
        </a></p>
            )}</Col>
          <Col>{this.state.token ? (<a href="logout" className="App-link">Logout</a>) : (<p></p>)}
            <div>{this.state.name}</div></Col>
        </Row>
        <Row>
          <Col>1 of 3</Col>
          <Col>{this.state.token ? (
<div><SimpleTable token={this.state.token} projectDetailsChanged={this.state.projectDetailsChanged}></SimpleTable>
           { /*<List component="nav" aria-label="main mailbox folders">
              {this.state.projectDetails.map(item => (
                <ListItem button>
                  <ListItemText primary={item.name} />
                </ListItem>

              ))}
            </List*/}
            
            </div>
          ) : (<p></p>)}</Col>
          <Col><p><SimpleModal callBack={this.addProject} token={this.state.token}/></p></Col>
        </Row>
      </Container>
    </div>
  }
}

export default App
