import 'date-fns';
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import DateFnsUtils from '@date-io/date-fns';
import Button from '@material-ui/core/Button';

import {
    MuiPickersUtilsProvider,
    KeyboardTimePicker,
    KeyboardDatePicker,
} from '@material-ui/pickers';

function rand() {
    return Math.round(Math.random() * 20) - 10;
}

function getModalStyle() {
    const top = 50 + rand();
    const left = 50 + rand();

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}

const useStyles = makeStyles(theme => ({
    paper: {
        position: 'absolute',
        width: 400,
        backgroundColor: theme.palette.background.paper,
        border: '2px solid #000',
        boxShadow: theme.shadows[5],
        padding: theme.spacing(2, 4, 3),
    },
    root: {
        '& > *': {
            margin: theme.spacing(1),
            width: '25ch',
        },
    },
}));

export default function SimpleModal(props) {
    const classes = useStyles();
    // getModalStyle is not a pure function, we roll the style only on the first render
    const [modalStyle] = React.useState(getModalStyle);
    const [open, setOpen] = React.useState(false);

    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleDateChange = date => {
        // setSelectedDate(date);
    };

    const submitProject = () => {
        console.log("Submit log called : " + props.token)
        let projectDetails = { name : "Somethisssng", startDate : "2020-03-29T08:38:00.051Z", endDate : "2022-03-29T08:38:00.051Z"}
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json',  'Authorization': 'Bearer ' + props.token },
            body: JSON.stringify(projectDetails)
        };
        fetch('http://localhost:9191/projectdetails', requestOptions)
            .then(response => response.json())
            .then(data => {
            handleClose();
            props.callBack()});
    };

    //const [selectedDate, setSelectedDate] = React.useState(new Date('2014-08-18T21:11:54'));


    return (
        <div>
            <button type="button" onClick={handleOpen}>
                Open Modal
      </button>
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={open}
                onClose={handleClose}
            >
                <div style={modalStyle} className={classes.paper}>
                    <h2 id="simple-modal-title">Add Project</h2>
                    <form className={classes.root} noValidate autoComplete="off">
                        <TextField id="name" label="Name" variant="outlined" placeholder="Some Project"  size="small"/>
                        <TextField id="starteDate" label="Start Date" variant="outlined" placeholder="mm/dd/yyyy"  size="small"/>
                        <TextField id="endDate" label="End Date" variant="outlined" placeholder="mm/dd/yyyy"  size="small"/>
                        <Button variant="contained" color="primary" onClick={submitProject}>
                            Primary
                        </Button>
                    </form>
                </div>

            </Modal>
        </div>
    );
}