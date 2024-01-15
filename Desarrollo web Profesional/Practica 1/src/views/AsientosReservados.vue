<template>
    <div>
        <b-container fluid>
            <b-row>
                <b-col>
                    <BreadcrumReservas />
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h1>Asientos reservados</h1>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'AsientosReservados',
    components: {
        BreadcrumReservas: () =>
            import ('@/components/breadscrumb/BreadcrumReservas.vue'),
    },
}
</script>