import Contact from "Frontend/generated/com/example/demo/data/Contact";
import {FC, useEffect} from "react";
import {useForm} from "@vaadin/hilla-react-form";
import ContactModel from "Frontend/generated/com/example/demo/data/ContactModel";
import {Button, TextField} from "@vaadin/react-components";

interface ContactEditorProps {
    contact: Contact;
    onSubmit: (contact: Contact) => Promise<void>;
}

const ContactEditor:FC<ContactEditorProps> = ({ contact, onSubmit}) => {

    const { field, model, submit, read } = useForm(ContactModel, {onSubmit});

    useEffect(() => {
        read(contact);
    }, [contact]);


    return (
        <div className='grid grid-col-2 gap-s items-baseline'>
            <TextField label={"Name"} {...field(model.name)}/>
            <TextField label={"Phone"} {...field(model.phone)}/>
            <TextField label={"Email"} {...field(model.email)}/>
            <Button onClick={submit} theme='primary'>Save</Button>
        </div>
    );
};

export default ContactEditor;
