import '../styles/index.css';
import {ContactService} from "Frontend/generated/endpoints";
import {AutoCrud} from "@vaadin/hilla-react-crud";
import ContactModel from "Frontend/generated/com/example/demo/data/ContactModel";

const Index = () => {


    return <AutoCrud service={ContactService} model={ContactModel} />
};

export default Index;
