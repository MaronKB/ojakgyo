const updateAd = async (form) => {
    event.preventDefault();
    const id = Number(form.adId.value);
    const title = form.title.value;
    const category = form.category.value;
    const image = form.image.value;
    const desc = form.desc.value;
    const link = form.link.value;
    const expDate = form.end.value;
    const isValid = form.status.value;

    const ad = {
        id: id,
        title: title,
        category: category,
        image: image,
        desc: desc,
        link: link,
        expDate: expDate ? expDate + " " + "23:59:59" : null,
        isValid: isValid
    };
    try {
        const response = await fetch(`/api/ad/${ad.id}`, {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ad)
        });
        if (response.ok) {
            await setAdsList();
            await createAdsList();
        }
    } catch (error) {
        console.error(error);
    }
    closeAdModal();
}