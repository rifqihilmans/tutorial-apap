import React, { Component } from "react";
import APIConfig from "../../api/ApiConfig";
import Button from "../../components/Button";
import Hotel from "../../components/Hotel";
import classes from "./styles.module.css";
import Modal from "../../components/Modal";
import Pagination from "../../components/Pagination";

class HotelList extends Component{
    constructor(props){
        super(props);
        this.state = {
            hotels: [],
            listKamar: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isSearch: false,
            query: "",
            namaHotel:"",
            alamat:"",
            nomorTelepon:"",
            namaKamar: "",
            kapasitasKamar: "",
            page: 1,
            totalPerPage: 5,
        };
        this.handleAddHotel = this.handleAddHotel.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
        this.handleEditHotel = this.handleEditHotel.bind(this);
        this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
        this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
        this.handleSearchInput = this.handleSearchInput.bind(this);
    }

    handleSearchInput(event) {
        const query = event.target.value;
        this.setState({ isSearch: true });
        
        this.setState(a => {
            const filteredHotel = a.hotels.filter(e => {
                return e.namaHotel.toLowerCase().startsWith(query.toLowerCase());
            });
        
            return {
                query,
                filteredHotel,
            };
        });
    };

    handleAddHotel(){
        this.setState({ isCreate: true });
    }

    handleChangeField(event){
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditHotel(hotel){
        this.setState({
            isEdit: true,
            id: hotel.id,
            namaHotel: hotel.namaHotel,
            alamat: hotel.alamat,
            nomorTelepon: hotel.nomorTelepon,
        });
    }

    async handleSubmitEditHotel(event){
        event.preventDefault();
        try{
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.put(`/hotel/${this.state.id}`, data);
            this.loadData();
        }catch(error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleCancel(event){
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    async handleDeleteHotel(id){
        try {
            await APIConfig.delete(`/hotel/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }            
    }

    async handleSubmitAddHotel(event){
        event.preventDefault();
        try{
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };   
            await APIConfig.post("/hotel", data);
            this.loadData();
            this.setState({
                namaHotel: "",
                alamat: "",
                nomorTelepon: "",
            });
        }catch(error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    componentDidMount(){
        this.loadData();
    }

    async loadData(){
        try{
            const { data } = await APIConfig.get("/hotels");
            this.setState({ hotels: data });
        }catch(error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render(){
        const { hotels } = this.state;

        const listHotel = hotels.slice(0, 5);

        const paginate = (number) =>{
            this.setState({
                page:number
            })
        }

        return(
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <Button onClick={this.handleAddHotel} variant="primary">
                    Add Hotel
                </Button>
                <form>
                    <input
                    className={classes.search}
                    placeholder="Cari hotel"
                    value={this.state.query}
                    onChange={this.handleSearchInput}
                    />
                </form>
                <div>
                    {this.state.isSearch ?  this.state.filteredHotel.map(hotel => {
                        return(
                            <Hotel
                            key={hotel.id}
                            id={hotel.id}
                            namaHotel={hotel.namaHotel}
                            alamat={hotel.alamat}
                            nomorTelepon={hotel.nomorTelepon}
                            listKamar={hotel.listKamar}
                            handleEdit={() => this.handleEditHotel(hotel)}
                            handleDelete={() => this.handleDeleteHotel(hotel.id)}
                            />
                        )
                    }) : listHotel.map(hotel => {
                        return(
                            <Hotel
                            key={hotel.id}
                            id={hotel.id}
                            namaHotel={hotel.namaHotel}
                            alamat={hotel.alamat}
                            nomorTelepon={hotel.nomorTelepon}
                            listKamar={hotel.listKamar}
                            handleEdit={() => this.handleEditHotel(hotel)}
                            handleDelete={() => this.handleDeleteHotel(hotel.id)}
                            />
                        );
                    })}
                </div>
                <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal = {this.handleCancel}>
                    <form>
                        <h3 className={classes.modalTitle}>
                            {this.state.isCreate
                            ? "Add Hotel"
                            :`Edit Hotel Nomor ${this.state.id}`}
                        </h3>
                        <input
                        className={classes.textField}
                        type="text"
                        placeholder="Nama Hotel"
                        name="namaHotel"
                        value={this.state.namaHotel}
                        onChange={this.handleChangeField}
                        />
                        <input
                        className={classes.textField}
                        type="text"
                        placeholder="Alamat"
                        name="alamat"
                        value={this.state.alamat}
                        onChange={this.handleChangeField}
                        />
                        <textarea
                        className={classes.textField}
                        placeholder="Nomor Telepon"
                        name="nomorTelepon"
                        rows="4"
                        value={this.state.nomorTelepon}
                        onChange={this.handleChangeField}
                        />
                        <Button
                            onClick={
                                this.state.isCreate
                                ? this.handleSubmitAddHotel
                                : this.handleSubmitEditHotel
                            }
                            variant="primary"
                        >
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>
                        <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                        </Button>
                    </form>
                </Modal>
                <div>
                    <Pagination total={this.state.hotels.length} page={this.state.totalPerPage} paginate={paginate}/>
                </div>
            </div>
        );
    }
}

export default HotelList;